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
import com.piriurna.appstoreclone.ui.main.adapters.EditorsChoiceAdapter
import com.piriurna.appstoreclone.ui.main.adapters.LocalTopAppsAdapter
import com.piriurna.common.extensions.getDimensionInDp
import com.piriurna.common.helpers.HorizontalMarginItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding : FragmentMainBinding

    private val editorsChoiceAdapter : EditorsChoiceAdapter by lazy {
        EditorsChoiceAdapter(emptyList())
    }

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

        binding.editorsChoice.adapter = editorsChoiceAdapter

        binding.editorsChoice.addItemDecoration(HorizontalMarginItemDecoration(16))

        binding.localTopApps.addItemDecoration(HorizontalMarginItemDecoration(resources.getDimensionInDp(R.dimen.base_margin)))

        subscribeObservers()
    }


    private fun subscribeObservers() {
        viewModel.getAppList()

        viewModel.loading.observe(viewLifecycleOwner, Observer { loading ->
            binding.loading.root.visibility = if(loading) View.VISIBLE else View.GONE
        })

        viewModel.localTopAppsList.observe(viewLifecycleOwner, Observer {
            localTopAppsAdapter.items = it
        })

        viewModel.editorChoiceAppsList.observe(viewLifecycleOwner, Observer {
            editorsChoiceAdapter.items = it
        })
    }
}