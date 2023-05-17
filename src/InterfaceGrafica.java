import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class InterfaceGrafica extends JFrame implements ActionListener {
    
    ConexaoBancoDeDados objBancoDeDados;
    
    private JButton botaoRemover;
    private JButton botaoInserir;
    private JButton botaoPesquisar;
    private JButton botaoAlterar;
    
    private JLabel lbNome;
    private JLabel lbEndereco;
    private JLabel lblTelefone;
    private JLabel lblCPF;
    private JLabel lblTipoSanguineo;
    private JLabel lblTipoCurso;
    private JLabel lbContatoEmergencia;
    private JLabel lblTelefoneEmergencia;
    private JLabel lbId;
    private JLabel lblMensagem;
    private JLabel lblItemSelecionado;
    private JLabel lblFatorRh;
    private JLabel lblResultadoPesquisa;
    
    private final String [] tipoSanguineo = { "A","B", "A/B" ,"O"};
    private final String [] FatorRh = { "+" ,"-"};
    private final String [] TipoCurso = { "Direito" , "ciência da computação","sistemas de informação","Medicina"," Psicologia","nutrição"};
    
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textTelefone;
    private JFormattedTextField textCPF;
    private JTextField textContatoEmergencia;
    private JTextField textTelefoneEmergencia;
    private JTextField textId;
    
    private JComboBox cmbTipoSanguineo;
    private JComboBox cmbTipoCurso;
    private JComboBox cmbFatorRh;
    
    private JTextArea ListaPesquisaBancoDeDados;
    private JScrollPane scrollPesquisaBancoDeDados;
    
    private Container ctn;
    
  public InterfaceGrafica() {
    
      setSize(1000,600);
      setTitle(" Sistema de Cadastro ");
      ctn = getContentPane();
      ctn.setLayout(null);
      
      lbNome = new JLabel("Nome:");
      textNome = new JTextField();
      lblMensagem = new JLabel("-----");
      lblItemSelecionado = new JLabel(" -----");
      lbEndereco = new JLabel("Endereco:");
      textEndereco = new JTextField();
      lblCPF = new JLabel("CPF:");
      lblTelefone = new JLabel("Telefone:");
      lblTelefoneEmergencia = new JLabel("Telefone de emergência:");
      lbContatoEmergencia = new JLabel("Contato de emergência:");
      lbId = new JLabel("Id:");
      textId = new JTextField();
      textContatoEmergencia = new JTextField();
      lblResultadoPesquisa = new JLabel(" Resultado da Pesquisa no Banco De Dados");
      
      ListaPesquisaBancoDeDados = new JTextArea();
      scrollPesquisaBancoDeDados = new JScrollPane(ListaPesquisaBancoDeDados);
      
      botaoInserir = new JButton("Inserir");
      botaoPesquisar = new JButton("Pesquisar");
      botaoAlterar = new JButton("Alterar");
      botaoRemover = new JButton("Remover");
      
      try {
        textTelefoneEmergencia = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
      }
      
      catch (ParseException e) {
        e.printStackTrace();
      }
      try {
        textTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
      }
      
      catch (ParseException e) {
        e.printStackTrace();
      }
      try {
        textCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
      }
      
      catch (ParseException e) {
        e.printStackTrace();
      }
      
    
      setLayout(null); 
      

      lblTipoSanguineo = new JLabel(" TipoSanguineo ");
      cmbTipoSanguineo = new JComboBox(tipoSanguineo);
      lblFatorRh = new JLabel(" Fator RH: ");
      cmbFatorRh = new JComboBox(FatorRh);
      lblTipoCurso = new JLabel(" Curso ");
      cmbTipoCurso = new JComboBox(TipoCurso);
      lblMensagem.setBounds(50,10,100,25);
      lbNome.setBounds(0,10,100,25);
      textNome.setBounds(40,10,150,25);
      lbEndereco.setBounds(0,50,100,25);
      textEndereco.setBounds(60,50,200,25);
      lblTelefone.setBounds(0,100,200,25);
      textTelefone.setBounds(60,100,100,25);
      lblCPF.setBounds(0,150,100,25);
      textCPF.setBounds(60,150,100,25);
      lblTipoSanguineo.setBounds(0,200,100,25);
      cmbTipoSanguineo.setBounds(100,200,50,25);
      lblFatorRh.setBounds(250,200,100,25);
      cmbFatorRh.setBounds(350,200,50,25);
      lblTipoCurso.setBounds(0,250,100,25);
      cmbTipoCurso.setBounds(100,250,150,25);
      lbContatoEmergencia.setBounds(0,300,300,25);
      textContatoEmergencia.setBounds(150,300,150,25);
      lblTelefoneEmergencia.setBounds(0,350,350,25);
      textTelefoneEmergencia.setBounds(150,350,200,25);
      botaoRemover.setBounds(20,400,100,30);
      botaoInserir.setBounds(150,400,100,30);
      botaoPesquisar.setBounds(20,450,100,30);
      botaoAlterar.setBounds(150,450,100,30);
      lbId.setBounds(300,450,100,30);
      textId.setBounds(320,450,100,30);
      lblResultadoPesquisa.setBounds(550,50,300,30);
      scrollPesquisaBancoDeDados.setBounds(500,80,400,400);
      
      
      
      ctn.add(lbNome);
      ctn.add(textNome);
      ctn.add(lbEndereco);
      ctn.add(textEndereco);
      ctn.add(lblCPF);
      ctn.add(textCPF);
      ctn.add(lblTelefone);
      ctn.add(textTelefone);
      ctn.add(lblTipoSanguineo);
      ctn.add(cmbTipoSanguineo);
      ctn.add(lblFatorRh);
      ctn.add(cmbFatorRh);
      ctn.add(lblTipoCurso);
      ctn.add(cmbTipoCurso);
      ctn.add(lbContatoEmergencia);
      ctn.add(textContatoEmergencia);
      ctn.add(lblMensagem);
      ctn.add(lblItemSelecionado);
      ctn.add(lblResultadoPesquisa);
      ctn.add(scrollPesquisaBancoDeDados);
      ctn.add(lblTelefoneEmergencia);
      ctn.add(textTelefoneEmergencia);
      ctn.add(botaoRemover);
      ctn.add(botaoInserir);
      ctn.add(botaoPesquisar);
      ctn.add(botaoAlterar);
      ctn.add(lbId);
      ctn.add(textId);
      
      
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       botaoInserir.addActionListener(this);
       botaoRemover.addActionListener(this);
       botaoAlterar.addActionListener(this);
       botaoPesquisar.addActionListener(this);
        
  }
  

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Inserir"))
    {
      Aluno objeto = new Aluno(textNome.getText(),textEndereco.getText(),textTelefone.getText(),textCPF.getText(),cmbTipoCurso.getSelectedItem().toString(),textContatoEmergencia.getText(),textTelefoneEmergencia.getText(),cmbTipoSanguineo.getSelectedItem().toString(),cmbFatorRh.getSelectedItem().toString());
      
      try { ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
           String  mensagem =  objBancoDeDados.InserirDados(objeto);
           lblMensagem.setText(mensagem);
           JOptionPane.showMessageDialog(this, "Dados Inseridos com sucesso!");
       } catch(Exception e1) 
           {JOptionPane.showMessageDialog(this, "Dados não foram alterados!");
        e1.printStackTrace();
    
               }
    }
    
    if (e.getActionCommand().equals("Remover"))
    {
      Aluno objeto = new  Aluno(textNome.getText(),textEndereco.getText(),textTelefone.getText(),textCPF.getText(),cmbTipoCurso.getSelectedItem().toString(),textContatoEmergencia.getText(),textTelefoneEmergencia.getText(),cmbTipoSanguineo.getSelectedItem().toString(),cmbFatorRh.getSelectedItem().toString());
      
       try { ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
          int id = Integer.parseInt(textId.getText());
          String  mensagem =  objBancoDeDados.RemoverDados(id);
           lblMensagem.setText(mensagem);
           JOptionPane.showMessageDialog(this, "Dados removidos com sucesso!");
            
       } catch(Exception e1) 
         {JOptionPane.showMessageDialog(this, "Dados não foram alterados!");
       e1.printStackTrace();
    
               }
    }

    if (e.getActionCommand().equals("Alterar"))
    {
      Aluno objeto = new  Aluno(textNome.getText(),textEndereco.getText(),textTelefone.getText(),textCPF.getText(),cmbTipoCurso.getSelectedItem().toString(),textContatoEmergencia.getText(),textTelefoneEmergencia.getText(),cmbTipoSanguineo.getSelectedItem().toString(),cmbFatorRh.getSelectedItem().toString());
      
      try { ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
            int id = Integer.parseInt(textId.getText());
            String  mensagem =  objBancoDeDados.AlterarDados(objeto,id);
            lblMensagem.setText(mensagem);
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
       } catch(Exception e1) 
           {JOptionPane.showMessageDialog(this, "Dados não foram alterados!");
         e1.printStackTrace();
    
                }
   }

  
    if (e.getActionCommand().equals("Pesquisar"))
    { 
        try { ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
        ArrayList<String> relatorioBancoDeDados = objBancoDeDados.Relatorio();
        
        ListaPesquisaBancoDeDados.setText("");
        for (String texto:relatorioBancoDeDados )
        {
          ListaPesquisaBancoDeDados.append(texto + " \n\n");    
        }
           
            
        } catch(Exception e1) 
        
           {
         e1.printStackTrace();
    
               }
    }
 
  
}

  



  public static void main(String[] args) {
  
    InterfaceGrafica objetoInterface = new InterfaceGrafica();
  
  }

}
