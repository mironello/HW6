with Youngest as (
    select
        'YOUNGEST' as type,
        name,
        birthday
    from
        worker
    order by
        birthday ASC
    limit 1
),
     Oldest as (
         select
             'OLDEST' as type,
             name,
             birthday
         from
             worker
         order by
             birthday desc
         limit 1
     )
select * from Youngest
union all
select * from Oldest;