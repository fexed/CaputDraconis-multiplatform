import SwiftUI
import expelliarmus

struct ContentView: View {
    let iosspells = loadSpells()
    
    var body: some View {
        List {
            ForEach(iosspells) { iosspell in
                SpellElement(spell: iosspell)
            }
        }
    }
}

func loadSpells() -> [iOSSpell] {
    let spells = iOSSpellsLoader().LoadSpells()
    
    var outputList = [iOSSpell]()
    spells.forEach { spell in
        outputList.append(iOSSpell(id: UUID(), nome: spell.nome, descrizione: spell.descrizione, difinc: spell.difinc, categoria: spell.categoria, fonte: spell.fonte))
    }
    
    return outputList
}

struct SpellElement: View {
    var spell: iOSSpell
    
    var body: some View {
        VStack {
            HStack {
                Text(spell.nome).font(.headline).multilineTextAlignment(.leading)
                Spacer()
            }
            HStack {
                Text(spell.categoria).font(.body).multilineTextAlignment(.leading)
                Spacer()
                Text(spell.fonte).font(.caption).multilineTextAlignment(.trailing)
            }
        }.onTapGesture {
            print("Tapped " + spell.nome)
        }.frame(
            maxWidth: .infinity,
            maxHeight: .infinity
        )
    }
}

struct iOSSpell: Identifiable {
    let id: UUID
    let nome: String
    let descrizione: String
    let difinc: String
    let categoria: String
    let fonte: String
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
