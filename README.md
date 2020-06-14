###codeshuai社区
###资料
[github的仓库地址](https://github.com/BEshakalaka/community)
[github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

###工具

###脚本
```sql
create table user
(
	id int(255) auto_increment
		primary key,
	account_id varchar(100) null,
	name varchar(50) null,
	token char(36) null,
	gmt_create bigint(255) null,
	gmt_modified bigint(255) null
);
```
