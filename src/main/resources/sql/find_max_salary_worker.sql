/** select max salary worker

 */

select name, salary from worker where salary = (select max(salary) from worker);