package com.piriurna.appstoreclone.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.piriurna.appstoreclone.R
import com.piriurna.appstoreclone.databinding.FragmentMainBinding
import com.piriurna.appstoreclone.ui.main.adapters.LocalTopAppsAdapter
import com.piriurna.domain.models.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding : FragmentMainBinding

    private val localTopAppsAdapter : LocalTopAppsAdapter by lazy {
        LocalTopAppsAdapter(emptyList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.localTopApps.adapter = localTopAppsAdapter

        subscribeObservers()
    }


    private fun subscribeObservers() {
        viewModel.getAppList()

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "Loading $it", Toast.LENGTH_SHORT)
        })

        viewModel.appList.observe(viewLifecycleOwner, Observer {
            localTopAppsAdapter.items = it
        })


    }
}