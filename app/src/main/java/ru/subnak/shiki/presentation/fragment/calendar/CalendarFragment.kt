package ru.subnak.shiki.presentation.fragment.calendar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.subnak.shiki.R
import ru.subnak.shiki.databinding.FragmentCalendarBinding

import ru.subnak.shiki.presentation.ShikiApp
import ru.subnak.shiki.presentation.ViewModelFactory
import ru.subnak.shiki.presentation.adapter.calendar.CalendarOngoingsAdapter
import javax.inject.Inject

class CalendarFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var calendarViewModel: CalendarViewModel

    private var _binding: FragmentCalendarBinding? = null
    private val binding: FragmentCalendarBinding
        get() = _binding ?: throw RuntimeException("Calendar fragment binding is null")

    private val component by lazy {
        (requireActivity().application as ShikiApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[CalendarViewModel::class.java]

        val adapterCalendar = CalendarOngoingsAdapter()
        val layoutManagerCalendar = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManagerCalendar

        adapterCalendar.onCalendarOngoingsClickListener = {
            launchNotificationsFragment(it)
        }

        binding.recyclerView.adapter = adapterCalendar

        calendarViewModel.result.observe(viewLifecycleOwner) {
            adapterCalendar.submitList(it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun launchNotificationsFragment(animeId: Int) {
        findNavController().navigate(
            CalendarFragmentDirections.actionNavigationCalendarToNavigationNotifications(animeId)
        )
    }

    private fun launchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}