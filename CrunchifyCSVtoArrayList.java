package appchamada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



public class CrunchifyCSVtoArrayList {
    
    //Cria frame para usuario abrir arquivo
    public JFileChooser diretorio = new JFileChooser();
    //Cria filtro para arquivos CSV
    FileNameExtensionFilter filtro = new FileNameExtensionFilter ("Arquivo TXT", "txt");
    public ArrayList<Aluno> CSVtoArrayList(){
		//Adiciona filto a diretorio
                this.diretorio.addChoosableFileFilter(filtro);
                //Cria filtro para arquivos TXT
                filtro = new FileNameExtensionFilter("Arquivo CSV", "csv");
                //adiciona filtro para arquivos TXT
                this.diretorio.addChoosableFileFilter(filtro);
                
                //Cria um buffer de leitura e inicializa nulo
		BufferedReader crunchifyBuffer = null;
		//Cria uma string e inicializa nulo, irá receber informação da linha corrente
		String linha = null;
                //Cria frame para usuario abrir arquivo
                JFileChooser diretorio = new JFileChooser();
                //Cria filtro para arquivos CSV
                FileNameExtensionFilter filter= new FileNameExtensionFilter ("Arquivo CSV", "csv");
                diretorio.addChoosableFileFilter(filter);
                //Cria filtro para arquivos TXT
                filter = new FileNameExtensionFilter ("Arquivo TXT", "txt");
                diretorio.addChoosableFileFilter(filter);
                //Novo Teste
		// here we create a container for readed and splitted lines. Este é um arraylist de strings
		ArrayList<String[]> linhas = new ArrayList<String[]>();

		//Este é um arraylist de alunos
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
                
                //Recebe a resposta se o arquivo foi selecionado ou não
                int resposta;
                //Armazena a resposta
                resposta = diretorio.showOpenDialog(diretorio);
                
                if(resposta==JFileChooser.APPROVE_OPTION){
		//try, catch
		try{
			//Cria o buffer para ler o arquivo
			BufferedReader br=new BufferedReader(new FileReader(diretorio.getSelectedFile()));

			//Enquanto as linhas do arquivo não forem nulas
			while((linha=br.readLine())!=null){

				//Cria o array aluno para armazenar cada linha do ArrayList 
				String[] aluno=linha.split(";");

				// here we add each readed and splitted line
				linhas.add(aluno);

				//Adiciona o novo aluno ao ArrayList de alunos através de colunas com os respectivos indices
				alunos.add(new Aluno (aluno[0],aluno[1]) );

			}//Fim do while
			br.close();
                        return alunos;

		}catch(IOException e){
			e.printStackTrace();
		} // Finaliza bloco Try Catch
            }
            if(resposta==JFileChooser.CANCEL_OPTION){
                diretorio.cancelSelection();
                return null;
            }
            return null;
    }
        public int salvarArquivo(ArrayList<Aluno> dadostoArq, String dataChamada, String Curso, String Turma, String data2) throws IOException{
            Scanner ler = new Scanner(System.in);
            int i, resposta;
            String nomearq;
            nomearq = Curso +"_" + Turma + "_" + dataChamada + ".txt";
            diretorio.setSelectedFile(new File(nomearq));
            resposta = diretorio.showSaveDialog(diretorio);
            if(resposta==JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Cancelado");
                return 0;
            }
            else
            {
            
            FileWriter arq = new FileWriter(diretorio.getSelectedFile());
            PrintWriter gravarArq = new PrintWriter(arq);
            
            gravarArq.println("MATRICULA;NOME;" + data2);
            for (i=0; i<dadostoArq.size(); ++i) {
                gravarArq.printf(dadostoArq.get(i).getMatricula() + ";" + dadostoArq.get(i).getNome() + ";");
                if(dadostoArq.get(i).isStatus()==true){
                    gravarArq.println("P");
                }
                else
                {
                    gravarArq.println("F");
                }
            }
            arq.close();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
            return 1;
        }
    }
 
}
        
	

