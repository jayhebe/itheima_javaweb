DROP TABLE IF EXISTS tb_order;

DROP TABLE IF EXISTS tb_goods;

DROP TABLE IF EXISTS tb_order_goods;

CREATE TABLE
    tb_order(
        id INT PRIMARY KEY AUTO_INCREMENT,
        payment DOUBLE(9, 2) NOT NULL,
        payment_type VARCHAR(255) NOT NULL,
        status VARCHAR(255) NOT NULL
    );

CREATE TABLE
    tb_goods(
        id INT PRIMARY KEY AUTO_INCREMENT,
        title VARCHAR(255) NOT NULL,
        price DOUBLE(9, 2) NOT NULL
    );

CREATE TABLE
    tb_order_goods(
        id INT PRIMARY KEY AUTO_INCREMENT,
        order_id INT NOT NULL,
        goods_id INT NOT NULL,
        CONSTRAINT fk_to_order FOREIGN KEY tb_order_goods(order_id) REFERENCES tb_order(id),
        CONSTRAINT fk_to_goods FOREIGN KEY tb_order_goods(goods_id) REFERENCES tb_goods(id)
    );

INSERT INTO
    tb_order (payment, payment_type, status)
VALUES (7376, "微信支付", "未付款"), (59880, "支付宝支付", "已付款");

INSERT INTO
    tb_goods (title, price)
VALUES ("华为P40手机", 5988), ("海天酱油", 9.9), ("华为GT2手表", 1388);

SELECT * FROM tb_order;

SELECT * FROM tb_goods;

INSERT INTO
    tb_order_goods (order_id, goods_id)
VALUES (1, 1), (1, 3), (2, 1);

SELECT * FROM tb_order_goods;

SELECT 
    a.id,
    a.order_id,
    a.title,
    a.price,
    a.count,
    o.payment,
    o.payment_type,
    o.status
FROM
    (
        SELECT
            d.id,
            d.order_id,
            d.count,
            g.title,
            g.price
        FROM
            tb_order_goods d
        LEFT JOIN
            tb_goods g
        ON
            d.goods_id = g.id
    ) a
LEFT JOIN
    tb_order o
ON 
    a.order_id = o.id;

ALTER TABLE tb_order_goods ADD COLUMN count INT NOT NULL;

UPDATE tb_order_goods SET count = 1 WHERE id = 1;
UPDATE tb_order_goods SET count = 1 WHERE id = 2;
UPDATE tb_order_goods SET count = 10 WHERE id = 3;