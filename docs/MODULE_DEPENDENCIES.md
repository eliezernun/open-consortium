# Dependências iniciais

```text
shared-kernel
  └── regulation
        └── product-catalog
              └── group
                    └── quota
                          └── contribution

ledger depende apenas de shared-kernel e regulation.

assembly coordena group, quota, contribution e ledger.

contemplation depende do resultado de assembly.

closure coordena group, quota, contribution e ledger.

integration expõe contratos externos sem comandar o domínio.
```

Essa topologia é inicial. Dependências deverão ser reduzidas por APIs públicas e eventos à medida que os contratos forem implementados.
