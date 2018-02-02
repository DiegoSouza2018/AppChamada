package appchamada;

public class Aluno{
	
	private String matricula;
        private String nome;
        private int totalFaltas;
        private boolean status;

    public Aluno() {
        this.matricula = "VAZIA";
        this.nome = "VAZIA";
        this.totalFaltas = 0;
        this.status = false;
    }

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.totalFaltas = 0;
        this.status = false;
    }    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotalFaltas() {
        return totalFaltas;
    }

    public void setTotalFaltas(int totalFaltas) {
        this.totalFaltas = totalFaltas;
    }

}

