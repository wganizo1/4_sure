package wganz.assessment.adapters
    import ModelSpells
    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.LinearLayout
    import android.widget.TextView
    import wganz.assessment.R

class AdapterSpells(context: Context,arrayListDetails:ArrayList<ModelSpells>) : BaseAdapter(){

        private val layoutInflaterSpells: LayoutInflater
        private val arrayListDetails:ArrayList<ModelSpells>

        init {
            this.layoutInflaterSpells = LayoutInflater.from(context)
            this.arrayListDetails=arrayListDetails
        }

        override fun getCount(): Int {
            return arrayListDetails.size
        }

        override fun getItem(position: Int): Any {
            return arrayListDetails.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val listRowHolderspells: ListRowHolderSpells
            if (convertView == null) {
                view = this.layoutInflaterSpells.inflate(R.layout.adapter_layout_spells, parent, false)
                listRowHolderspells = ListRowHolderSpells(view)
                view.tag = listRowHolderspells
            } else {
                view = convertView
                listRowHolderspells = view.tag as ListRowHolderSpells
            }
            listRowHolderspells.tvName.text = arrayListDetails.get(position).name
            listRowHolderspells.tvTyp.text = "Type "+arrayListDetails.get(position).typ
            listRowHolderspells.tvId.text = arrayListDetails.get(position).id
            listRowHolderspells.tvEffect.text = "Effect "+arrayListDetails.get(position).effect
            return view
        }
    }

    private class ListRowHolderSpells(row: View?) {
         val tvName: TextView
         val tvTyp: TextView
         val tvId: TextView
         val tvEffect: TextView
         val thumbnail: ImageView
         val linearLayout: LinearLayout

        init {
            this.tvId = row?.findViewById(R.id.tvId) as TextView
            this.tvName = row?.findViewById(R.id.tvName) as TextView
            this.tvTyp = row?.findViewById(R.id.tvTym) as TextView
            this.thumbnail = row?.findViewById(R.id.thumbnail) as ImageView
            this.tvEffect = row?.findViewById(R.id.tvEffect) as TextView
            this.linearLayout = row?.findViewById(R.id.linearLayout) as LinearLayout
        }
    }