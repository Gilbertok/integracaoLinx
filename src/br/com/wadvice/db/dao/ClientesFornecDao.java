package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.ClientesFornecModel;

public class ClientesFornecDao extends DefaultDao {
	
	private static String sqlCreate = "CREATE TABLE WAD_LINX_CLI_FORN ( "+
									"    PORTAL VARCHAR2(20 BYTE), "+
									"	COD_CLIENTE VARCHAR2(20 BYTE), "+
									"	RAZAO_CLIENTE VARCHAR2(60 BYTE), "+
									"	NOME_CLIENTE VARCHAR2(60 BYTE), "+
									"	DOC_CLIENTE VARCHAR2(14 BYTE) NOT NULL ENABLE, "+
									"	TIPO_CLIENTE VARCHAR2(1 BYTE), "+
									"	ENDERECO_CLIENTE VARCHAR2(250 BYTE), "+
									"	NUMERO_RUA_CLIENTE VARCHAR2(20 BYTE), "+
									"	COMPLEMENT_END_CLI VARCHAR2(60 BYTE), "+
									"	BAIRRO_CLIENTE VARCHAR2(60 BYTE), "+
									"	CEP_CLIENTE VARCHAR2(9 BYTE), "+
									"	CIDADE_CLIENTE VARCHAR2(40 BYTE), "+
									"	UF_CLIENTE VARCHAR2(20 BYTE), "+
									"	PAIS VARCHAR2(80 BYTE), "+
									"	FONE_CLIENTE VARCHAR2(20 BYTE), "+
									"	EMAIL_CLIENTE VARCHAR2(50 BYTE), "+
									"	SEXO VARCHAR2(1 BYTE), "+
									"	DATA_CADASTRO DATE, "+
									"	DATA_NASCIMENTO DATE, "+
									"	CEL_CLIENTE VARCHAR2(20 BYTE), "+
									"	ATIVO VARCHAR2(1 BYTE), "+
									"	DT_UPDATE DATE, "+
									"	INSCRICAO_ESTADUAL VARCHAR2(20 BYTE), "+
									"	INSCRICAO_MUNICIPAL VARCHAR2(20 BYTE), "+
									"	IDENTIDADE_CLIENTE VARCHAR2(20 BYTE), "+
									"	CARTAO_FIDELIDADE VARCHAR2(20 BYTE), "+
									"	COD_IBGE_MUNICIPIO VARCHAR2(20 BYTE), "+
									"	CLASSE_CLIENTE VARCHAR2(100 BYTE), "+
									"	MATRICULA_CONVENIADO VARCHAR2(20 BYTE), "+
									"	TIPO_CADASTRO VARCHAR2(1 BYTE), "+
									"	ID_ESTADO_CIVIL NUMBER(1,0), "+
									"	FAX_CLIENTE VARCHAR2(50 BYTE), "+
									"	SITE_CLIENTE VARCHAR2(20 BYTE), "+
									"	EMPRESA_CADASTRO NUMBER(1,0), "+
									"	CONSTRAINT WAD_LINX_CLI_FORN_PK PRIMARY KEY (DOC_CLIENTE))";
	private static String nomeTabela = "WAD_LINX_CLI_FORN";
	
	public ClientesFornecDao() {
		super(nomeTabela, sqlCreate);
	}

	public void gravarLista(List<ClientesFornecModel> clientes) throws SQLException {
		this.criaCasoNaoExista();
		for (ClientesFornecModel cliente : clientes) {
			if(cliente.getCpfCnpj() != null && !cliente.getCpfCnpj().isEmpty()) {
				if (this.exists(cliente)) {
					this.update(cliente);
				} else {
					this.insert(cliente);
				}
			}
		}
	}

	private void insert(ClientesFornecModel cliente) throws SQLException {
		String query = "INSERT INTO WAD_LINX_CLI_FORN " + 
						"	(PORTAL, COD_CLIENTE, RAZAO_CLIENTE, NOME_CLIENTE, DOC_CLIENTE, "+
						"	TIPO_CLIENTE, ENDERECO_CLIENTE, NUMERO_RUA_CLIENTE, COMPLEMENT_END_CLI, BAIRRO_CLIENTE, "+
						"	CEP_CLIENTE, CIDADE_CLIENTE, UF_CLIENTE, PAIS, FONE_CLIENTE, "+
						"	EMAIL_CLIENTE, SEXO, DATA_CADASTRO, DATA_NASCIMENTO, CEL_CLIENTE, "+
						"	ATIVO, DT_UPDATE, INSCRICAO_ESTADUAL, INSCRICAO_MUNICIPAL, IDENTIDADE_CLIENTE, "+
						"	CARTAO_FIDELIDADE, COD_IBGE_MUNICIPIO, CLASSE_CLIENTE, MATRICULA_CONVENIADO, TIPO_CADASTRO, "+
						"	ID_ESTADO_CIVIL, FAX_CLIENTE, SITE_CLIENTE, EMPRESA_CADASTRO) "+
						"VALUES " + 
						"    (?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, cliente.getPortal());
		stmt.setString(2, cliente.getCodigoCliente());
		stmt.setString(3, cliente.getRazao());
		stmt.setString(4, cliente.getNome());
		stmt.setString(5, cliente.getCpfCnpj());
		
		stmt.setString(6, cliente.getTipoCliente());
		stmt.setString(7, cliente.getEndereco());
		stmt.setString(8, cliente.getNumero());
		stmt.setString(9, cliente.getComplemento());
		stmt.setString(10, cliente.getBairro());
		
		stmt.setString(11, cliente.getCep());
		stmt.setString(12, cliente.getCidade());
		stmt.setString(13, cliente.getUf());
		stmt.setString(14, cliente.getPais());
		stmt.setString(15, cliente.getTelefone());
		
		stmt.setString(16, cliente.getEmail());
		stmt.setString(17, cliente.getSexo());
		stmt.setDate(18, cliente.getDataCadastro() != null ? new Date(cliente.getDataCadastro().getTime()) : null);
		stmt.setDate(19, cliente.getDataNasciemnto() != null ? new Date(cliente.getDataNasciemnto().getTime()) : null);
		stmt.setString(20, cliente.getCelular());
		
		stmt.setString(21, cliente.getAtivo());
		stmt.setDate(22, cliente.getDataUpdate() != null ? new Date(cliente.getDataUpdate().getTime()) : null);
		stmt.setString(23, cliente.getInscricaoEstadual());
		stmt.setString(24, cliente.getInscricaoMunicipal());
		stmt.setString(25, cliente.getIdentidade());
		
		stmt.setString(26, cliente.getCartaoFidelidade());
		stmt.setInt(27, cliente.getCodigoIbgeMunicipio());
		stmt.setString(28, cliente.getClasse());
		stmt.setString(29, cliente.getMatricula());
		stmt.setString(30, cliente.getTipoCadastro());
		
		stmt.setString(31, cliente.getIdEstadoCivil());
		stmt.setString(32, cliente.getFax());
		stmt.setString(33, cliente.getSite());
		stmt.setInt(34, cliente.getEmpresa());
		stmt.execute();
		stmt.close();
	}

	private void update(ClientesFornecModel cliente) throws SQLException {
		String query = "UPDATE WAD_LINX_CLI_FORN SET " + 
						"	COD_CLIENTE = ?, RAZAO_CLIENTE = ?, NOME_CLIENTE = ?, TIPO_CLIENTE = ?, ENDERECO_CLIENTE = ?, "+
						"	NUMERO_RUA_CLIENTE = ?, COMPLEMENT_END_CLI = ?, BAIRRO_CLIENTE = ?, CEP_CLIENTE = ?, CIDADE_CLIENTE = ?, "+
						"	UF_CLIENTE = ?, PAIS = ?, FONE_CLIENTE = ?, EMAIL_CLIENTE = ?, SEXO = ?, "+
						"	DATA_CADASTRO = ?, DATA_NASCIMENTO = ?, CEL_CLIENTE = ?, ATIVO = ?, DT_UPDATE = ?, "+
						"	INSCRICAO_ESTADUAL = ?, INSCRICAO_MUNICIPAL = ?, IDENTIDADE_CLIENTE = ?, CARTAO_FIDELIDADE = ?, COD_IBGE_MUNICIPIO = ?, "+
						"	CLASSE_CLIENTE = ?, MATRICULA_CONVENIADO = ?, TIPO_CADASTRO = ?, ID_ESTADO_CIVIL = ?, FAX_CLIENTE = ?, "+
						"	SITE_CLIENTE = ? "+
						"WHERE DOC_CLIENTE = ? AND EMPRESA_CADASTRO = ?";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setString(1, cliente.getCodigoCliente());
		stmt.setString(2, cliente.getRazao());
		stmt.setString(3, cliente.getNome());
		stmt.setString(4, cliente.getTipoCliente());
		stmt.setString(5, cliente.getEndereco());
		
		stmt.setString(6, cliente.getNumero());
		stmt.setString(7, cliente.getComplemento());
		stmt.setString(8, cliente.getBairro());
		stmt.setString(9, cliente.getCep());
		stmt.setString(10, cliente.getCidade());
		
		stmt.setString(11, cliente.getUf());
		stmt.setString(12, cliente.getPais());
		stmt.setString(13, cliente.getTelefone());
		stmt.setString(14, cliente.getEmail());
		stmt.setString(15, cliente.getSexo());
		
		stmt.setDate(16, cliente.getDataCadastro() != null ? new Date(cliente.getDataCadastro().getTime()) : null);
		stmt.setDate(17, cliente.getDataNasciemnto() != null ? new Date(cliente.getDataNasciemnto().getTime()) : null);
		stmt.setString(18, cliente.getCelular());
		stmt.setString(19, cliente.getAtivo());
		stmt.setDate(20, cliente.getDataUpdate() != null ? new Date(cliente.getDataUpdate().getTime()) : null);
		
		stmt.setString(21, cliente.getInscricaoEstadual());
		stmt.setString(22, cliente.getInscricaoMunicipal());
		stmt.setString(23, cliente.getIdentidade());
		stmt.setString(24, cliente.getCartaoFidelidade());
		stmt.setInt(25, cliente.getCodigoIbgeMunicipio());
		
		stmt.setString(26, cliente.getClasse());
		stmt.setString(27, cliente.getMatricula());
		stmt.setString(28, cliente.getTipoCadastro());
		stmt.setString(29, cliente.getIdEstadoCivil());
		stmt.setString(30, cliente.getFax());
		
		stmt.setString(31, cliente.getSite());
		stmt.setString(32, cliente.getCpfCnpj());
		stmt.setInt(33, cliente.getEmpresa());
		stmt.executeUpdate();
		stmt.close();
	}

	private boolean exists(ClientesFornecModel cliente) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_CLI_FORN WHERE DOC_CLIENTE = ? AND EMPRESA_CADASTRO = ? ";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, cliente.getCpfCnpj());
			stmt.setInt(2, cliente.getEmpresa());
			stmt.setMaxRows(1);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				exists = true;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

}
