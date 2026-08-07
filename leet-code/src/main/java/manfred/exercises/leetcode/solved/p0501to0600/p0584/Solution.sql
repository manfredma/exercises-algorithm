-- LeetCode 第 584 题：寻找用户推荐人
-- 表 Customer(id, name, referee_id)
-- 找出:被 id != 2 的用户推荐,或未被任何用户推荐的客户姓名
-- TODO: 待实现
select name from Customer where referee_id != 2 or referee_id is null