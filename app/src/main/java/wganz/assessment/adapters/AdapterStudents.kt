package wganz.assessment.adapters
    import ModelStudents
    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.LinearLayout
    import android.widget.TextView
    import wganz.assessment.R

class AdapterStudents(context: Context,arrayListDetails:ArrayList<ModelStudents>) : BaseAdapter(){

        private val listRowHolderstudents: LayoutInflater
        private val arrayListDetails:ArrayList<ModelStudents>

        init {
            this.listRowHolderstudents = LayoutInflater.from(context)
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
            val listRowHolderstudents: ListRowHolderStudents
            if (convertView == null) {
                view = this.listRowHolderstudents.inflate(R.layout.adapter_layout_students, parent, false)
                listRowHolderstudents = ListRowHolderStudents(view)
                view.tag = listRowHolderstudents
            } else {
                view = convertView
                listRowHolderstudents = view.tag as ListRowHolderStudents
            }
            listRowHolderstudents.tvName.text = arrayListDetails.get(position).name
            listRowHolderstudents.tvId.text = arrayListDetails.get(position).id
            return view
        }
    }

    private class ListRowHolderStudents(row: View?) {
         val tvName: TextView
         val tvId: TextView
         val thumbnail: ImageView
         val linearLayout: LinearLayout

        init {
            this.tvId = row?.findViewById(R.id.tvId) as TextView
            this.tvName = row?.findViewById(R.id.tvName) as TextView
            this.thumbnail = row?.findViewById(R.id.thumbnail) as ImageView
            this.linearLayout = row?.findViewById(R.id.linearLayout) as LinearLayout
        }
    }