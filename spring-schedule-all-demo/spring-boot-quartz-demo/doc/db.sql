DROP TABLE IF EXISTS `quartz_task_infor`;
CREATE TABLE `quartz_task_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL COMMENT '版本号：需要乐观锁控制',
  `task_no` varchar(64) NOT NULL COMMENT '任务编号',
  `task_name` varchar(64) NOT NULL COMMENT '任务名称',
  `scheduler_rule` varchar(64) NOT NULL COMMENT '定时规则表达式',
  `frozen_status` varchar(16) NOT NULL COMMENT '冻结状态',
  `executor_no` varchar(128) NOT NULL COMMENT '执行方',
  `frozen_time` bigint(13) DEFAULT NULL COMMENT '冻结时间',
  `unfrozen_time` bigint(13) DEFAULT NULL COMMENT '解冻时间',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `lastModify_time` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  `send_type` varchar(64) DEFAULT NULL COMMENT '发送方式',
  `url` varchar(64) DEFAULT NULL COMMENT '请求地址',
  `execute_paramter` varchar(2000) DEFAULT NULL COMMENT '执行参数',
  `time_key` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务信息表';

DROP TABLE IF EXISTS `quartz_task_records`;
CREATE TABLE `quartz_task_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_no` varchar(64) NOT NULL COMMENT '任务编号',
  `time_key_value` varchar(32) DEFAULT NULL COMMENT '执行时间格式值',
  `execute_time` bigint(13) NOT NULL COMMENT '执行时间',
  `task_status` varchar(16) NOT NULL COMMENT '任务状态',
  `fail_count` int(10) DEFAULT NULL COMMENT '失败统计数',
  `fail_reason` varchar(64) DEFAULT NULL COMMENT '失败错误描述',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `last_modify_time` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_task_records_task_no` (`task_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务执行情况记录表';

DROP TABLE IF EXISTS `quartz_task_errors`;
CREATE TABLE `quartz_task_errors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_execute_recordId` varchar(64) NOT NULL COMMENT '任务执行记录Id',
  `error_key` varchar(1024) NOT NULL COMMENT '信息关键字',
  `error_value` text COMMENT '信息内容',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `last_modify_time` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务出错现场信息表';