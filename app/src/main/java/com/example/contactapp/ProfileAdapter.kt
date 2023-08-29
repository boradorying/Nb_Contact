package com.example.contactapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.RvItem2Binding
import com.example.contactapp.databinding.RvItemBinding

class ProfileAdapter(private var profiles: MutableList<Profile>, private var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  val VIEW_TYPE_NORMAL = 0
     private val VIEW_TYPE_BOOKMARKED = 1

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

//    companion object {
//        private const val VIEW_TYPE_NORMAL = 0
//        private const val VIEW_TYPE_BOOKMARKED = 1}
//     컴페니언오브젝트를 클래스 내에서 초기화한 상수들을 클래스 외부에서 직접 접근할 수 없고 클래스이름을 통해서 접근 가능 캡슐화,네임스페이스?구분 명확해짐 맴버에 접근할 때 클래스 이름사용해서만 접근 가능



    override fun getItemViewType(position: Int): Int {
        return if (profiles[position].bookmark) {
            VIEW_TYPE_BOOKMARKED
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val binding = RvItemBinding.inflate(inflater, parent, false)
                ViewHolder(binding)
            }
            VIEW_TYPE_BOOKMARKED -> {
                val binding = RvItem2Binding.inflate(inflater, parent, false)
                BookmarkedViewHolder(binding)
            }
            else -> throw IllegalArgumentException("")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_NORMAL -> {
                val normalViewHolder = holder as ViewHolder
                normalViewHolder.bindItems(profiles[position])
            }
            VIEW_TYPE_BOOKMARKED -> {
                val bookmarkedViewHolder = holder as BookmarkedViewHolder
                bookmarkedViewHolder.bindItems(profiles[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    inner class ViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.bookmarkArea.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(position)
                }
            }

            binding.phoneArea.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val phoneNumber = profiles[position].number
                    mackPhoneCall(phoneNumber)
                }
            }
        }
        private fun mackPhoneCall(phoneNumber: String){
            val dialIntent = Intent(Intent.ACTION_DIAL).apply{
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(binding.root.context, dialIntent, null)
        }


        fun bindItems(item: Profile) {
            binding.profileArea.setImageResource(item.imageResourceId)
            binding.nameArea.text = item.name
            binding.callArea.text = item.number
            if (item.bookmark) {
                binding.bookmarkArea.setBackgroundResource(R.drawable.baseline_star_24)
            } else {
                binding.bookmarkArea.setBackgroundResource(R.drawable.baseline_star_outline_24)
            }
        }
    }

    inner class BookmarkedViewHolder(private val binding: RvItem2Binding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.bookmarkArea.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(position)
                }
            }
            binding.phoneArea.setOnClickListener {
                val position =adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val phoneNumber = profiles[position].number
                    mackPhoneCall(phoneNumber)
                }
            }

        }
        private fun mackPhoneCall(phoneNumber: String){
            val dialIntent = Intent(Intent.ACTION_DIAL).apply{
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(binding.root.context, dialIntent, null)
        }

        fun bindItems(item: Profile) {
            binding.profileArea.setImageResource(item.imageResourceId)
            binding.nameArea.text = item.name
            binding.callArea.text = item.number
            if (item.bookmark) {
                binding.bookmarkArea.setBackgroundResource(R.drawable.baseline_star_24)
            } else {
                binding.bookmarkArea.setBackgroundResource(R.drawable.baseline_star_outline_24)
            }
        }
    }

}
