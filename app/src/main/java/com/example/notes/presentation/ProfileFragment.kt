package com.example.notes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.R
import com.example.notes.databinding.ProfileFragmentBinding
import com.example.notes.domain.entity.Profile
import com.example.notes.presentation.viewModel.ProfileFragmentViewModel
import com.example.notes.presentation.viewModel.ViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var profile: Profile

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    private var _binding: ProfileFragmentBinding? = null
    private val binding: ProfileFragmentBinding
        get() = _binding ?: throw RuntimeException("ProfileFragmentBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileFragmentViewModel::class.java]

        binding.tvName.text = profile.name
        binding.tvEmail.text = profile.email
        binding.tvPhone.text = profile.phone
        binding.tvPosition.text = profile.position

        binding.ivExit.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun parseArgs() {

        requireArguments().getParcelable<Profile>(ARG_KEY)?.let {
            profile = it
        }
    }

    companion object {

        fun newInstance(profile: Profile): Fragment {
            return ProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_KEY, profile)
                }
            }
        }

        private const val ARG_KEY = "Argument"

        const val NAME = "ProfileFragment"
    }
}