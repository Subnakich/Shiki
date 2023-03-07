package ru.subnak.shiki.presentation.fragment.userrates

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ru.subnak.shiki.databinding.FragmentUserRatesBinding
import ru.subnak.shiki.presentation.ShikiApp
import ru.subnak.shiki.presentation.ViewModelFactory
import javax.inject.Inject

class UserRatesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var userRatesViewModel: UserRatesViewModel

    private var _binding: FragmentUserRatesBinding? = null
    private val binding: FragmentUserRatesBinding
        get() = _binding ?: throw RuntimeException("User rates fragment binding is null")

    private val args by navArgs<UserRatesFragmentArgs>()

    private val component by lazy {
        (requireActivity().application as ShikiApp).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserRatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userRatesViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[UserRatesViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}