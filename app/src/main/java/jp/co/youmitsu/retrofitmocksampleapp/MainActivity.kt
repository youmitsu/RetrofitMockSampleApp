package jp.co.youmitsu.retrofitmocksampleapp

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jp.co.youmitsu.retrofitmocksampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerViewAdapter

    lateinit var repository: Repository

    val listData: MutableList<ZipData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = Repository()
        adapter = RecyclerViewAdapter(listData)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.list.adapter = adapter
    }

    fun onClickSearch() {
        val inputZipCode = binding.editText.text.toString()
        repository.searchZipCode(inputZipCode, { data ->
            listData.clear()
            data.forEach {
                listData.add(it)
            }
            adapter.notifyDataSetChanged()
        }, { message ->
        })
    }
}

class RecyclerViewAdapter(
    val data: List<ZipData>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}