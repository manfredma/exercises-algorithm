-- LeetCode 第 1757 题：可回收且低脂的产品
-- 表 Products(product_id, low_fats, recyclable)
-- 找出既是低脂(low_fats='Y')又是可回收(recyclable='Y')的产品编号
select product_id from 326Products where low_fats = 'Y' AND recyclable = 'Y'