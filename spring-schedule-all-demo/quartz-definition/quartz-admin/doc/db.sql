-- 任务表-tb_time_task
create table tb_time_task (
    id int(11) auto_increment primary key,
    nam varchar(50) comment `任务名`,
    group_name varchar(50) comment `任务组`,
    start_time timestamp comment `开始时间`,
    end_time timestamp  comment `结束时间`,
    cron varchar(30) comment `表达式`,
    job_status varchar(20) comment `发布状态`,
    plan_status varchar(20) comment `计划状态`,
    is_concurrent tinyint(4) comment `运行状态`,
    job_data varchar(50) comment `参数`,
    method_name varchar(50) comment `方法`,
    bean_name varchar(100) comment `实例`,
    description varchar(1000) comment `任务描述`,
    create_user_id varchar(32) comment `创建用户`,
    create_date timestamp comment `创建日期`,
    modify_user_id varchar(32) comment `修改用户`,
    modify_date timestamp comment `修改日期`,
)
-- 任务运行日志-tb_time_task_log
