package uz.nurulloxon.viewpagerhomework.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import uz.nurulloxon.viewpagerhomework.HomeActivity
import uz.nurulloxon.viewpagerhomework.MainActivity
import uz.nurulloxon.viewpagerhomework.Models.ViewData
import uz.nurulloxon.viewpagerhomework.databinding.ViewItemBinding

class ViewPagerAdapterIndicator(var itemList: List<ViewData>) :
    RecyclerView.Adapter<ViewPagerAdapterIndicator.Vh>() {

    inner class Vh(private val binding: ViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(viewData: ViewData) {

            binding.viewItemIdTitle.text = viewData.title
            binding.viewItemIdText.text = viewData.text
            binding.backImage.setBackgroundResource(viewData.backImage!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun onClickItem(index: Int) {

    }

}