package gaur.himanshu.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HostFragment : Fragment() {


    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController=Navigation.findNavController(view)

        val first=view.findViewById<Button>(R.id.first)
        val second=view.findViewById<Button>(R.id.second)
        val third=view.findViewById<Button>(R.id.third)

        first.setOnClickListener {

            val ourData=OurData("This is Data")

            val bundle= bundleOf("data" to ourData)

            navController.navigate(R.id.action_hostFragment_to_firstFragment,bundle)
        }
        second.setOnClickListener {
            navController.navigate(R.id.action_hostFragment_to_secondFragment)
        }

        third.setOnClickListener {
            navController.navigate(R.id.action_hostFragment_to_thirdFragment)
        }
    }

}