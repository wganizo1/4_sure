 class ModelSpells{
        lateinit var id:String
        lateinit var name:String
        lateinit var typ:String
         lateinit var effect:String

        constructor(id: String,name:String,typ:String,effect:String) {
                this.id = id
                this.name = name
                this.typ = typ
                this.effect = effect
        }

        constructor()
}