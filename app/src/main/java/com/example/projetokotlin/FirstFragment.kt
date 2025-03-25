package com.example.projetokotlin

import SharedViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetokotlin.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    //inicializar visualização
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        sharedViewModel.nome.observe(viewLifecycleOwner) { nome ->
            binding.nome.setText(nome)
        }

        sharedViewModel.endereco.observe(viewLifecycleOwner) { endereco ->
            binding.endereco.setText(endereco)
        }

        sharedViewModel.idade.observe(viewLifecycleOwner) { idade ->
            binding.idade.setText(idade)
        }


        binding.buttonFirst.setOnClickListener {
            val nome = binding.nome.text.toString()
            sharedViewModel.setNome(nome)

            val endereco = binding.endereco.text.toString()
            sharedViewModel.setEndereco(endereco)

            val idadeTexto = binding.idade.text.toString()
           sharedViewModel.setIdade(idadeTexto)

            val idade = if (idadeTexto.isNotEmpty()) {
                idadeTexto.toIntOrNull()
                    ?: 0
            } else {
                0
            }

            if (idade !== 0) {

                if (nome.isEmpty() === false && endereco.isEmpty() === false) {
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                } else {
                    Toast.makeText(context, "Campos Vazios!!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "Idade Invalida", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}