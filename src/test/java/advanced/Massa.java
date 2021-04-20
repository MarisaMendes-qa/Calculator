package advanced;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileNotFoundException; //exceção criada se o arquivo não for encontrado
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class) //Classe é executada com parametros
public class Massa {
    public String id;
    public String num1;
    public String operador;
    public String num2;
    public String resultadoEsperado;
    public String devicename;
    public String deviceName;

    //passagem de valores que esta no arquivo para a memória, por isso o Constructor
    public Massa(String id, String num1, String operador, String num2, String resultadoEsperado, String devicename) {
        this.id = id;
        this.num1 = num1;
        this.operador = operador;
        this.num2 = num2;
        this.resultadoEsperado = resultadoEsperado;
        this.devicename = devicename;
    }

    //Criar uma Collections é uma função(pois retorna, alguma coisa)
    @Parameterized.Parameters
    public static Collection<String[]> lerCSV(String nomeMassa) throws IOException {//tratamento de erros
        List<String[]> dados = new ArrayList<String[]>(); // dados é uma lista matriz com colunas e linhas bidimensional
        //dado é um prato(caixinha) a linha é uma colher arquivo é a comida.
        String linha; // o arquivo consome uma linha de cada vez
        BufferedReader arquivo = new BufferedReader( new FileReader(nomeMassa));//memoria fotográfica declara uma nova leitor de arquivos
        while ((linha = arquivo.readLine())!= null){

            String campos[] = linha.split(";"); //campos são os vários quadradinhos quebrados da barra de chocolate
            dados.add(campos);

        }
        arquivo.close();


        return dados;

    }

}
