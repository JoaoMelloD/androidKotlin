import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _formData = MutableLiveData<String>()
    val formData: LiveData<String> get() = _formData

    fun clearFormData() {
        _nome.value = ""
        _endereco.value = ""
        _idade.value = ""
    }

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> get() = _nome

    private val _endereco = MutableLiveData<String>()
    val endereco: LiveData<String> get() = _endereco

    private val _idade = MutableLiveData<String>()
    val idade: LiveData<String> get() = _idade

    fun setNome(value: String) {
        _nome.value = value
    }

    fun setEndereco(value: String) {
        _endereco.value = value
    }

    fun setIdade(value: String) {
        _idade.value = value
    }
}
