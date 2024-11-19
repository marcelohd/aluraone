import java.io.IOException;
import java.util.Scanner;

import model.Endereco;
import service.ApiService;
import service.EscreveJson;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Endereco endereco = new Endereco();
        String pesquisa = "";
        
        ApiService apiService = new ApiService();
        EscreveJson escreveJson = new EscreveJson();

        while (!pesquisa.equalsIgnoreCase("sair")) {
            System.out.println("Qual o CEP deseja buscar ? Digite sair para finalizar");
            pesquisa = entrada.nextLine();
            if(pesquisa.equalsIgnoreCase("sair")){
                break;
            }

            try{
                if (!pesquisa.isBlank() || !pesquisa.isEmpty()) {
                    endereco = apiService.buscaCep(pesquisa);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                    System.out.printf("CEP encontrado !!! \nlocalidade é %s, %s, %s, %s\n", endereco.getLogradouro(),endereco.getLocalidade() + " - " +endereco.getUf(),endereco.getBairro(), endereco.getCep());
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                    System.out.println("Arquivo salvo na raiz do projeto com nome " + endereco.getCep().concat(".json"));
                    escreveJson.escreverJson(endereco);
                } else {
                    System.out.println("Cep não pode ser vazio");
                }
            } catch (IOException | RuntimeException e){
                System.out.println("Erro ao buscar o cep");
            }   
        }
    }
}

