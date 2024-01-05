package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentQuestionBinding
import com.example.lovetest.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var mBinding: FragmentResultBinding? = null
    private val binding get() = mBinding!!
    private lateinit var navController : NavController
    var option = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_result, container, false)

        option = arguments?.getInt("index") ?: -1


        mBinding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        
        setResult(option)

        binding.btnHome.setOnClickListener(this)
        
    }

    private fun setResult(option: Int) {
        when(option){
            1 -> {
                binding.tvMain.text = "You are a QUITTER!"
                binding.tvSub.text = "You can let the person easily."
            }
            2 -> {
                binding.tvMain.text = "You should focus on yourself"
                binding.tvSub.text = "You become really clingy to your ex."
            }
            3 -> {
                binding.tvMain.text = "You should take it easy"
                binding.tvSub.text = "You can do crazy things no matter what it takes."
            }
            4 -> {
                binding.tvMain.text = "You are pretty mature."
                binding.tvSub.text = "You can easily accept the break-up."
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_home -> {
                navController.navigate(R.id.action_resultFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}