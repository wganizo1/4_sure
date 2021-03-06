package wganz.assessment.adapters
    import ModelHouses
    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.LinearLayout
    import android.widget.TextView
    import wganz.assessment.R

class AdapterHouses(context: Context,arrayListDetails:ArrayList<ModelHouses>) : BaseAdapter(){

        private val layoutInflater: LayoutInflater
        private val arrayListDetails:ArrayList<ModelHouses>

        init {
            this.layoutInflater = LayoutInflater.from(context)
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
            val listRowHolder: ListRowHolder
            if (convertView == null) {
                view = this.layoutInflater.inflate(R.layout.adapter_layout_houses, parent, false)
                listRowHolder = ListRowHolder(view)
                view.tag = listRowHolder
            } else {
                view = convertView
                listRowHolder = view.tag as ListRowHolder
            }
            listRowHolder.tvName.text = arrayListDetails.get(position).name
            listRowHolder.tvMascot.text = "Mascot "+arrayListDetails.get(position).mascot
            listRowHolder.tvId.text = arrayListDetails.get(position).id
            listRowHolder.tvHead.text = "Head "+arrayListDetails.get(position).headOfHouse
            listRowHolder.tvGhost.text = "House Ghost "+arrayListDetails.get(position).houseGhost
            listRowHolder.tvFounder.text = "Founder "+arrayListDetails.get(position).founder
            return view
        }
    }

    private class ListRowHolder(row: View?) {
         val tvName: TextView
         val tvMascot: TextView
         val tvId: TextView
         val tvHead: TextView
         val tvFounder: TextView
         val tvGhost: TextView
         val thumbnail: ImageView
         val linearLayout: LinearLayout

        init {
            this.tvId = row?.findViewById(R.id.tvId) as TextView
            this.tvName = row?.findViewById(R.id.tvName) as TextView
            this.tvMascot = row?.findViewById(R.id.tvMascot) as TextView
            this.thumbnail = row?.findViewById(R.id.thumbnail) as ImageView
            this.tvHead = row?.findViewById(R.id.tvhead) as TextView
            this.tvFounder = row?.findViewById(R.id.tvFounder) as TextView
            this.tvGhost = row?.findViewById(R.id.tvGhost) as TextView
            this.linearLayout = row?.findViewById(R.id.linearLayout) as LinearLayout
        }
    }