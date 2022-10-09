package com.example.mylesson8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mylesson8.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val carList = arrayListOf<Car>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
             loadData()
        val adapter = CarsAdapter(carList, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        carList.add(Car("Mercedes Benz","https://i.imgur.com/Ne2yXLD.jpeg","2014"))
        carList.add(Car("BMW","https://i.imgur.com/1yDxlwG.jpeg","2012"))
        carList.add(Car("Audi","https://i.imgur.com/RomtZ29.jpeg","2018"))
        carList.add(Car("Toyota","https://i.imgur.com/qEFRVXL.jpeg","2019"))
        carList.add(Car("Lexus","https://i.imgur.com/EK9dYMp.jpeg","2015"))
        carList.add(Car("Nissan","https://i.imgur.com/xHIbdaT.jpeg","2014"))
        carList.add(Car("Mazda","https://i.imgur.com/sj5rBlM.jpeg","2010"))
        carList.add(Car("Volkswagen","https://i.imgur.com/3EZsLoQ.jpeg","2021"))
        carList.add(Car("LADA","https://i.imgur.com/gCnDdpW.jpeg","2022"))
        carList.add(Car("Hyundai","https://i.imgur.com/7bvg80C.png","2020"))

    }

    private fun onClick(position: Int){
        val car = carList[position]
        val bundle = Bundle()
        bundle.putSerializable("KEY",car)
        findNavController().navigate(R.id.secondFragment, bundle)

    }

}
