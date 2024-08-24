from collections import defaultdict

def gerarRelatorio(vendas,relatorio):
    vendas_por_produto = defaultdict(float)
    vendas_por_dia = defaultdict(float)
    total_geral = 0.0

    with open(vendas,'r')as arquivo:
        for linha in arquivo:
            linha = linha.strip()

            data,produto,quantidade,preco_unit = linha.split(',')

            quantidade = int(quantidade)
            preco_unit = float(preco_unit)

            total_venda = quantidade*preco_unit

            vendas_por_produto[produto]+= total_venda
            vendas_por_dia[data]+=total_venda
            total_geral+=total_venda

    with open(relatorio,'w') as arquivo:
        arquivo.write("         Relatório de Vendas         \n")
        arquivo.write("_____________________________________\n")

        arquivo.write("VENDAS POR PRODUTO:\n")
        for produto,total in vendas_por_produto.items():
            arquivo.write(f"{produto} R$ {total:.2f}\n")

        arquivo.write("-------------------------------------\n")    

        arquivo.write("VENDAS POR DIA:\n")
        for dia,total in vendas_por_dia.items():
            arquivo.write(f"{dia} R$ {total:.2f}\n")

        arquivo.write("-------------------------------------\n")    

        arquivo.write("TOTAL DE VENDAS:\n")
        arquivo.write(f"R$ {total_geral:.2f}\n")

    with open(relatorio,'r') as arquivo:
        rel = arquivo.read()
        print(rel)    

vendas ="vendas.txt"
relatorio="relatorio.txt"
gerarRelatorio(vendas,relatorio)


            






    


