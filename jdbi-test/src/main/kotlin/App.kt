import org.jdbi.v3.core.Jdbi

data class ReadClassroomModel(
    val cid: Int,
    val name: String,
    val description: String?,
)

data class InsertClassroomModel(
    val name: String,
    val description: String?,
)

fun main(args: Array<String>) {
    val jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/db", "user", "pass")

    val res = jdbi.withHandle<List<String>, Exception> {
        it.createQuery("select name from users")
            .mapTo(String::class.java)
            .list()
    }

    jdbi.useHandle<Exception> {
        it.execute("insert into USERS(name, gh_id, gh_token) values('Rodrigo', '6', 'token6')")
    }

    jdbi.useHandle<Exception> {
        it.createUpdate("insert into USER_CLASSROOM values(:type, :uid, :cid)")
            .bind("type", "student")
            .bind("uid", 6)
            .bind("cid", 3)
            .execute()
    }

    jdbi.useHandle<Exception> {
        it.createUpdate("insert into CLASSROOM(name, description) values(:name, :description)")
            .bindBean(InsertClassroomModel("i-on Android", "Classroom for i-on Android"))
            .execute()
    }

    jdbi.registerRowMapper(ReadClassroomModel::class.java) { rs, ctx ->
        ReadClassroomModel(rs.getInt("cid"), rs.getString("name"), rs.getString("description"))
    }

    val insertedClassroom = jdbi.withHandle<ReadClassroomModel, Exception> {
        it.createUpdate("insert into CLASSROOM(name) values(:name)")
            .bindBean(InsertClassroomModel("i-on Web", null))
            .executeAndReturnGeneratedKeys()
            .mapTo(ReadClassroomModel::class.java)
            .one()
    }

    val classroom = jdbi.withHandle<ReadClassroomModel, Exception> {
        it.createQuery("select * from CLASSROOM where cid = 1")
            .mapTo(ReadClassroomModel::class.java)
            .first()
    }

    jdbi.useHandle<Exception> {
        it.useTransaction<Exception> { tran ->
            tran.createUpdate("insert into CLASSROOM(name, description) values(:name, :description)")
                .bindBean(InsertClassroomModel("i-on Test", "Classroom for i-on Test"))
                .execute()
        }
    }
}