<h1>大的国家</h1>

这里有张World表</br>
+-----------------+------------+------------+--------------+---------------+</br>
| name            | continent  | area       | population   | gdp           |</br>
+-----------------+------------+------------+--------------+---------------+</br>
| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |</br>
| Albania         | Europe     | 28748      | 2831741      | 12960000      |</br>
| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |</br>
| Andorra         | Europe     | 468        | 78115        | 3712000       |</br>
| Angola          | Africa     | 1246700    | 20609294     | 100990000     |</br>
+-----------------+------------+------------+--------------+---------------+</br>
如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。</br>
编写一个SQL查询，输出表中所有大国家的名称、人口和面积。</br>

例如，根据上表，我们应该输出:</br>
+--------------+-------------+--------------+</br>
| name         | population  | area         |</br>
+--------------+-------------+--------------+</br>
| Afghanistan  | 25500100    | 652230       |</br>
| Algeria      | 37100000    | 2381741      |</br>
+--------------+-------------+--------------+</br>

Create table If Not Exists World (name varchar(255), continent varchar(255), area int, population int, gdp int)</br>
Truncate table World</br>
insert into World (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000')</br>
insert into World (name, continent, area, population, gdp) values ('Albania', 'Europe', '28748', '2831741', '12960000000')</br>
insert into World (name, continent, area, population, gdp) values ('Algeria', 'Africa', '2381741', '37100000', '188681000000')</br>
insert into World (name, continent, area, population, gdp) values ('Andorra', 'Europe', '468', '78115', '3712000000')</br>
insert into World (name, continent, area, population, gdp) values ('Angola', 'Africa', '1246700', '20609294', '100990000000')</br>

[Link](https://leetcode-cn.com/problems/big-countries/)