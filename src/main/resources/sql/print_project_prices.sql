SELECT
    p.id AS id,
    (DATE_PART('year', AGE(p.FINISH_DATE, p.START_DATE)) * 12 +
     DATE_PART('month', AGE(p.FINISH_DATE, p.START_DATE))) * SUM(w.SALARY) AS PRICE
FROM
    project p
        JOIN
    project_worker pw ON p.ID = pw.PROJECT_ID
        JOIN
    worker w ON pw.WORKER_ID = w.ID
GROUP BY
    p.ID
ORDER BY
    PRICE DESC;