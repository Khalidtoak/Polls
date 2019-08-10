package khalid.com.polls.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import khalid.com.polls.R
import khalid.com.polls.models.IntroData
import kotlinx.android.synthetic.main.intro_item_layout.view.*


/**
 * Created by  on 8/8/2019.
 */
class IntroSlideAdapter(var intrdata:List<IntroData>, var context: Context) : RecyclerView.Adapter<IntroSlideAdapter.IntroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder =
        IntroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.intro_item_layout,
            parent, false))

    override fun getItemCount(): Int  = 3

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.itemView.textView.text = intrdata[position].text
        holder.itemView.imageView.setImageDrawable(intrdata[position].image)
        val list  = listOf(holder.itemView.view,holder.itemView.view3,holder.itemView.view2 )
        list[position].background = context.getDrawable(R.drawable.rect_fill)
    }

    inner class IntroViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }
}