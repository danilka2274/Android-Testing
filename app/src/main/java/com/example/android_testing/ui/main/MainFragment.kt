package com.example.android_testing.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_testing.databinding.MainFragmentBinding
import com.example.android_testing.domain.Repository
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null
    private val repository: Repository by inject()
    private val mainViewModel: MainViewModel by viewModel()
    private var adapter: MainAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        adapter = MainAdapter()
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.adapter = adapter
        mainViewModel.openLiveData.observe(viewLifecycleOwner) {
            adapter?.load(it)
        }
        mainViewModel.getData()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}