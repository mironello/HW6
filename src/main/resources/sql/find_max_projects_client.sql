select
    c.name,
    count(p.id) as project_count
from
    client c
        join
    project p on c.id = p.client_id
group by
    c.name
having
        count (p.id) = (
        select
            count(id)
        from
            project
        group by
            client_id
        order by
            count(id) desc
        limit 1
    );