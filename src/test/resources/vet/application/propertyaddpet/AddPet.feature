Feature: Добавяне на домашен лщбимец

Scenario Outline: Добавяне на животно
      Given Ветеринарят избира добавяне на любимец
      When въведе име <име>
      And въведе порода <порода>
      And въведе идентификационен номер <номер>
      And въведе дата на раждане <дата>
      And натисне бутона за запис
      Then вижда съобщение <съобщение>
      Examples:
        | име | порода | номер | дата | съобщение |
        | "Алфи" | "куче" | "2858371503"| "10.07.2023" | "Успешно добавяне на домашен любимец." |
        | "Коко" | "златна риба" | "2658377503"| "17.06.2020" | "В базата съществува запис с този идентификационен номер." |
        | "Чарли" | "фжвхайфвафквхсйвярйккйсдгкнхирвхярхвихксдйглдйскасдк" | "К283577503"| "09.03.2018" | "Породата е прекалено дълга (до 50 символа)." |
        | "" | "заек" | "7603459813"| "10.07.2023" | "Попълнете име на животното." |
        | "Бела" | "" | "0343577503"| "10.07.2023" | "Попълнете порода на животното." |
        | "Попи" | "котка" | "9674024613"| "" | "Попълнете датата на раждане." |
        | "+%€§*(" | "папагал" | "9650843102"| "14.03.2000" | "Името може да съдържа само текст." |
        | "Макс" | "котка%€" | "0283577503"| "06.07.2015" | "Породата може да съдържа само текст." |
        | "фжвхайфвафквхсйвярйккйсдгкнхир" | "котка" | "7503340807"| "06.07.2015" | "Името е прекалено дълго (до 25 символа)." |
        | "Лола" | "котка" | "028357750308"| "06.07.2015" | "Идентификационният номер е прекалено дълъг (до 10 символа)." |
