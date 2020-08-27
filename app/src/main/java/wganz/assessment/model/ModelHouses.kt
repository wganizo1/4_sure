 class ModelHouses{
        lateinit var id:String
        lateinit var name:String
        lateinit var mascot:String
         lateinit var headOfHouse:String
         lateinit var houseGhost:String
         lateinit var founder:String
         lateinit var school:String

        constructor(id: String,name:String,mascot:String,headOfHouse:String,houseGhost:String,founder:String,school:String) {
                this.id = id
                this.name = name
                this.mascot = mascot
                this.headOfHouse = headOfHouse
                this.houseGhost = houseGhost
                this.founder = founder
                this.school = school
        }

        constructor()
}