CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m INT;
set m = n-1;
  RETURN (
      # Write your MySQL query statement below.
    SELECT distinct salary from Employee ORDER BY salary DESC limit m,1

  );
END