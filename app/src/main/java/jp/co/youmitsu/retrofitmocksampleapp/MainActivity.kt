package jp.co.youmitsu.retrofitmocksampleapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection
import jp.co.youmitsu.retrofitmocksampleapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager(this@MainActivity).orientation
                )
            )
        }
        binding.handler = this
    }

    fun onClickSearch() {
        val inputZipCode = binding.editText.text.toString()
        repository.searchZipCode(inputZipCode, { data ->
            (binding.list.adapter as? RecyclerViewAdapter)?.let {
                it.updateData(data)
                it.notifyDataSetChanged()
            }
        }, { message ->
        })
    }
}

class RecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var data: List<ZipData> = mutableListOf()

    fun updateData(newData: List<ZipData>) {
        data = newData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].apply {
            holder.address1.text = address1
            holder.address2.text = address2
            holder.address3.text = address3
            holder.kana1.text = kana1
            holder.kana2.text = kana2
            holder.kana3.text = kana3
            holder.zipcode.text = zipCode
            holder.prefcode.text = prefCode
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val address1: TextView = view.findViewById(R.id.address1)
        val address2: TextView = view.findViewById(R.id.address2)
        val address3: TextView = view.findViewById(R.id.address3)
        val kana1: TextView = view.findViewById(R.id.kana1)
        val kana2: TextView = view.findViewById(R.id.kana2)
        val kana3: TextView = view.findViewById(R.id.kana3)
        val zipcode: TextView = view.findViewById(R.id.zipcode)
        val prefcode: TextView = view.findViewById(R.id.prefcode)
    }
}