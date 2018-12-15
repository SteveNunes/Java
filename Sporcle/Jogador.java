package Sporcle;

public class Jogador {
	
	private int vidas, pontos, combo;
	private String nome;
	
	public Jogador() { resetar(); }
	public void resetar() { vidas = 6; pontos = 0; combo = 1; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public int getVidas() {	return vidas; }
	public void setVidas(int vidas) { this.vidas = vidas; }
	public int getPontos() { return pontos; }
	public void setPontos(int pontos) { this.pontos = pontos; }
	public int getCombo() { return combo; }
	public void setCombo(int combo) { this.combo = combo; }
	public void decrementarVida() {	if (vidas > 0) vidas--; }
	public void incrementarCombo() { combo++; }
	public void incrementarPontos(int pontos) { if (pontos > 0) this.pontos += pontos; }
	
}
