package com.piriurna.appstoreclone.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.load
import com.piriurna.appstoreclone.databinding.AppDetailsFragmentBinding
import com.piriurna.domain.models.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppDetailsFragment : Fragment() {

    private lateinit var appId : String


    lateinit var binding : AppDetailsFragmentBinding

    val viewModel : AppDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AppDetailsFragmentBinding.inflate(inflater, container, false)

        arguments?.getString("appId")?.let {
             appId = it
        }?: kotlin.run {
            //SHOW ERROR, but for now lets just set id 0
            appId = "0"
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getApp(appId)

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            binding.loading.root.visibility = if(it) View.VISIBLE else View.GONE
        })

        viewModel.app.observe(viewLifecycleOwner, Observer {
            setupViews(it)
        })

    }


    private fun setupViews(app : App) {
        binding.imgAppImage.load(app.graphic)

        binding.txtAppDownloads.text = "Downloads: ${app.downloads}"

        binding.txtAppName.text = app.name

        val tags = ""
        if(!app.apkTags.isNullOrEmpty()) {
            app.apkTags.reduce { fullString, current ->
                current?.let {
                    if(fullString?.indexOf(current) == 0){
                        "$current"
                    } else {
                        ", $current"

                    }
                }
            }
        }

        binding.txtAppTags.text = tags

        binding.txtAppRating.text = app.rating
    }

}