package sync;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.AdmicaoBEAN;
import modelo.Caixa;
import modelo.CaixaBEAN;
import modelo.CargoBEAN;
import modelo.ClienteBEAN;
import modelo.DespesaBEAN;
import modelo.EmpresaBEAN;
import modelo.DevolucaoBEAN;
import modelo.FuncionarioBEAN;
import modelo.Mesa;
import modelo.ProdutoBEAN;
import modelo.Produtos;
import modelo.ProdutosGravados;
import modelo.SangriaBEAN;
import modelo.Venda;
import modelo.VendaBEAN;
import modelo.local.SharedPreferencesBEAN;
import modelo.local.SharedPreferencesEmpresaBEAN;
import net.sf.jasperreports.engine.JasperPrint;
import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by itzda on 07/06/2018.
 */
public interface LojaAPI {

    // Servlets para testes no servidor local
    @FormUrlEncoded
    @POST("loja_server/FazLogin")
    Call<SharedPreferencesBEAN> fazLogin(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("empresa") String empresa);

    @FormUrlEncoded
    @POST("loja_server/ListarCargos")
    Call<ArrayList<CargoBEAN>> listarCargos(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ExcluirCargo")
    Call<Void> excluiCargo(@Field("cargo") String cargo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarCargoFuncionario")
    Call<CargoBEAN> listarCargoFuncionario(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("codFuncionario") String cod);

    @FormUrlEncoded
    @POST("loja_server/AdicionarCargo")
    Call<Void> insereCargo(@Field("cargo") String cargo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/EditarCargo")
    Call<Void> atualizaCargo(@Field("cargo") String cargo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarFuncionarios")
    Call<ArrayList<FuncionarioBEAN>> listarFuncionarios(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarFuncionario")
    Call<FuncionarioBEAN> listarFuncionario(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("funcionario") String cod);

    @FormUrlEncoded
    @POST("loja_server/GerarNumero")
    Call<Void> gerarNumFunPonto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AdicionarFuncionario")
    Call<Void> insereFuncionario(@Field("funcionario") String cargo, @Field("nomeUsuario") String empresa, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ExcluirFuncionario")
    Call<Void> excluiFuncionario(@Field("funcionario") String funcionario, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AdicionarProduto")
    Call<Void> insereProduto(@Field("produto") String cargo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AtualizaQuantidadeProduto")
    Call<Void> auteraQuantidadeProduto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("quantidade") String quantidade, @Field("produto") String proCodigo);

    @FormUrlEncoded
    @POST("loja_server/AtualizaProduto")
    Call<Void> atualizaProduto(@Field("produto") String cargo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarProdutos")
    Call<ArrayList<ProdutoBEAN>> listarProdutos(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarClientes")
    Call<ArrayList<ClienteBEAN>> listarClientes(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarClientes")
    Call<ArrayList<ClienteBEAN>> pesquisarClientes(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("nome") String nome);

    @FormUrlEncoded
    @POST("loja_server/AdicionarClienteVenda")
    Call<Void> adicionarClienteVenda(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("venda") String venda, @Field("cliente") String cliente);

    @FormUrlEncoded
    @POST("loja_server/AdicionarCliente")
    Call<Void> adicionarClientes(@Field("cliente") String cliente, @Field("endereco") String endereco);

    @FormUrlEncoded
    @POST("loja_server/ExcluirProduto")
    Call<Void> excluiProduto(@Field("produto") String produto, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/DevolucaoPedido")
    Call<Void> devolverPedido(@Field("devolucao") String devolucao, @Field("pedido") String pedido, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarProduto")
    Call<ProdutoBEAN> listarProduto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("produto") String cod);

    @FormUrlEncoded
    @POST("loja_server/BuscarUm")
    Call<Produtos> buscarUmProduto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("produto") String cod);

    @FormUrlEncoded
    @POST("loja_server/PesquisaProduto")
    Call<DefaultComboBoxModel> pesquisaProdutos(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("produto") String cod);

    @FormUrlEncoded
    @POST("loja_server/PesquisaProdutos")
    Call<ArrayList<Produtos>> buscarProdutos(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("produto") String cod);

    @FormUrlEncoded
    @POST("loja_server/AbrirCaixa")
    Call<Void> abrirCaixa(@Field("caixa") String caixa, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/FecharCaixa")
    Call<Void> fecharCaixa(@Field("caixa") String caixa, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/IncluirDespesa")
    Call<Void> incluirDespesas(@Field("despesa") String despesas, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ExcluirDespesa")
    Call<Void> excluiDespesa(@Field("despesa") String despesa, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/RetirarDespesaDia")
    Call<Void> retirarDespesa(@Field("despesa") String despesa, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/IsCaixaAberto")
    Call<Void> isCaixaAberto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarCaixa")
    Call<CaixaBEAN> listarCaixa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarDespesas")
    Call<ArrayList<DespesaBEAN>> listarDespesas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarDespesasDia")
    Call<ArrayList<DespesaBEAN>> listarDespesasDia(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/SaldoAtualCaixa")
    Call<Void> saldoAtualCaixa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/TotalVenda")
    Call<Void> getValorMesa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("venda") String mesa);

    @FormUrlEncoded
    @POST("loja_server/TotalVendidoCaixa")
    Call<Void> totalVendidoCaixa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/InserirSangria")
    Call<Void> inserirSangria(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("sangria") String sagria);

    @FormUrlEncoded
    @POST("loja_server/ValoresCaixa")
    Call<Caixa> buscarValoresCaixa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarProdutosVendidos")
    Call<ArrayList<ProdutosGravados>> listarProdutosVendidos(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarProdutosVenda")
    Call<ArrayList<ProdutosGravados>> listarProdutosVenda(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("venda") String mesa);

    @FormUrlEncoded
    @POST("loja_server/ListarVenda")
    Call<Venda> listarVenda(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("venda") String mesa);

    @FormUrlEncoded
    @POST("loja_server/AbrirVenda")
    Call<Void> abrirVenda(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/IncluirDespesaDia")
    Call<Void> incluirDespesasDia(@Field("despesa") String despesas, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarVendasAbertas")
    Call<ArrayList<Venda>> getVendasAbertas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarVendas")
    Call<ArrayList<Venda>> getVendas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarVendasStatus")
    Call<ArrayList<Venda>> getVendasPorStatus(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("status") String status);

    @FormUrlEncoded
    @POST("loja_server/ListarVendasConsulta")
    Call<ArrayList<Venda>> getVendasPorConsulta(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("consulta") String consulta);

    @FormUrlEncoded
    @POST("loja_server/ListarVendasData")
    Call<ArrayList<Venda>> getVendasPorData(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("dataIn") String dataIn, @Field("dataFin") String dataFin);

    @FormUrlEncoded
    @POST("loja_server/ListarVendasCombinacao")
    Call<ArrayList<Venda>> getVendasPorCombinacao(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("dataIn") String dataIn, @Field("dataFin") String dataFin,@Field("status") String status,@Field("consulta") String consulta);

    @FormUrlEncoded
    @POST("loja_server/IsMesasAbertas")
    Call<Void> isMesasAbertas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarExcluzaoMesa")
    Call<ArrayList<DevolucaoBEAN>> listarExcluzaoMesa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("mesa") String mesa);

    @FormUrlEncoded
    @POST("loja_server/ListarDevolucaoCaixa")
    Call<ArrayList<DevolucaoBEAN>> listarDevolucaoCaixa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AtualizaVenda")
    Call<Void> atualizaVenda(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AtualizaVendaPagamento")
    Call<Void> atualizaVendaPagamento(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AtualizaVendaNota")
    Call<ResponseBody> atualizaVendaNota(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AtualizaVendaCupom")
    Call<ResponseBody> atualizaVendaCupom(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/GerarCupomVenda")
    Call<ResponseBody> geraCupomVenda(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/GerarNotaVenda")
    Call<ResponseBody> geraNotaVenda(@Field("venda") String venda, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/InserirPedidoMesa")
    Call<Void> inserirPedidoMesa(@Field("pedido") String pedido, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/TranferirMesa")
    Call<Void> transferiMesa(@Field("mesaDestino") String destino, @Field("mesaOrigem") String origem, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/TranferirPedido")
    Call<Void> transferiPedido(@Field("mesaDestino") String destino, @Field("pedido") String pedido, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/CancelarPedido")
    Call<Void> cancelarPedido(@Field("pedido") String pedido, @Field("motivo") String motivo, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AdicionarEmpresa")
    Call<Void> insereEmpresa(@Field("empresa") String empresa);

    @FormUrlEncoded
    @POST("loja_server/LoginEmpresa")
    Call<SharedPreferencesEmpresaBEAN> fazLoginEmpresa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/AdicionarAdmicao")
    Call<Void> insereAdmicao(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("admicao") String admicao);

    @FormUrlEncoded
    @POST("loja_server/AdicionarDemicao")
    Call<Void> insereDemicao(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("demicao") String demicao);

    @FormUrlEncoded
    @POST("loja_server/LocalizarAdmicao")
    Call<AdmicaoBEAN> localisarAdmicao(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("funcionario") String funcionario);

    @FormUrlEncoded
    @POST("loja_server/ExcluirAdmicao")
    Call<Void> excluirAdmicao(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("admicao") String demicao);

    @FormUrlEncoded
    @POST("loja_server/ListarVendaFinalizadaCaixa")
    Call<ArrayList<VendaBEAN>> listarVendasFinalizadas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarSangria")
    Call<ArrayList<SangriaBEAN>> listarSangria(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/ListarEmpresa")
    Call<EmpresaBEAN> listarEmpresa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/EditarEmpresa")
    Call<Void> atualizaEmpresa(@Field("empresa") String empresa, @Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/GeraRelatorioProdutos")
    Call<ResponseBody> geraRelatorioProduto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("quantidade") String quantidade);

    @FormUrlEncoded
    @POST("loja_server/GeraRelatorioTodosProdutos")
    Call<ResponseBody> geraRelatorioTodosProduto(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/GeraRelatorioVendas")
    Call<ResponseBody> geraRelatorioVendas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha);

    @FormUrlEncoded
    @POST("loja_server/GeraRelatorioVendasData")
    Call<ResponseBody> geraRelatorioVendas(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("data") String data);

    @FormUrlEncoded
    @POST("loja_server/GeraRelatorioMesa")
    Call<ResponseBody> geraRelatorioMesa(@Field("nomeUsuario") String nomeUsuario, @Field("senha") String senha, @Field("venda") String codVenda);

}
