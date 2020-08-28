 class ModelStudents{
         lateinit var id:String
         lateinit var name:String
         lateinit var school:String
         lateinit var house:String
         lateinit var role:String

        constructor(id: String,name:String,role:String,house:String,school:String) {
                this.id = id
                this.name = name
                this.role = role
                this.school = school
                this.house = house
        }

        constructor()
}