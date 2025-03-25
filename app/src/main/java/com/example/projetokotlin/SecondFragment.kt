package com.example.projetokotlin

import SharedViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetokotlin.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.nome.observe(viewLifecycleOwner) { nome ->
            binding.nomeView.text = nome
        }

        sharedViewModel.endereco.observe(viewLifecycleOwner) { endereco ->
            binding.enderecoView.text = endereco
        }

        sharedViewModel.idade.observe(viewLifecycleOwner) { idade ->
            binding.idadeView.text = idade
        }

        binding.botaoNao.setOnClickListener {
            sharedViewModel.clearFormData()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        // esse daqui eu tenho que usar quando quero toast em um fragmento
        binding.botaoSim.setOnClickListener {
            Toast.makeText(requireActivity(), "Cadastrado com Sucesso!", Toast.LENGTH_LONG).show()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}