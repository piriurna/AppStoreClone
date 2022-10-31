package com.piriurna.appstoreclone.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.piriurna.appstoreclone.R
import com.piriurna.appstoreclone.databinding.FragmentMainBinding
import com.piriurna.appstoreclone.ui.main.adapters.AppClickListener
import com.piriurna.appstoreclone.ui.main.adapters.EditorsChoiceAdapter
import com.piriurna.appstoreclone.ui.main.adapters.LocalTopAppsAdapter
import com.piriurna.common.extensions.getDimensionInDp
import com.piriurna.common.helpers.HorizontalMarginItemDecoration
import com.piriurna.domain.models.App
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor(): Fragment(), AppClickListener {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding : FragmentMainBinding

    private val editorsChoiceAdapter : EditorsChoiceAdapter by lazy {
        EditorsChoiceAdapter(onItemClickListener = this)
    }

    private val localTopAppsAdapter : LocalTopAppsAdapter by lazy {
        LocalTopAppsAdapter(onItemClickListener = this)
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

    override fun onAppClicked(app: App) {
        val bundle = bundleOf("appId" to app.id.toString())
        findNavController().navigate(R.id.action_main_fragment_to_app_details_fragment, bundle)
    }
}