## 文件说明
1. `./Claude/results/function_generation/templateX` X代表template编号，代码生成部分不同template的生成结果会保存在对应的文件夹中。
2. `./Claude/results/statement_complete/templateX` X代表template编号，代码补全部分不同template的生成结果会保存在对应的文件夹中。
3. `./Claude/results/X` X代表其余文件，分别为代码补全和生产部分的实验结果统计文件。
4. `./Claude/results_safetemplate/function_generation/templateX` X代表template编号，安全prompt代码生成部分不同template的生成结果会保存在对应的文件夹中。
5. `./Claude/results_safetemplate/statement_complete/templateX` X代表template编号，安全prompt代码补全部分不同template的生成结果会保存在对应的文件夹中。
6. `/Claude/results_safetemplate/X` X代表其余文件，分别为安全prompt代码补全和生产部分的实验结果统计文件。
7. `claude.py` Cluade模型调用函数。
8. `codegenerator.py` 代码生成接口类。
9. `gencode.py` 获取数据，调用模型，生成代码。
10. `fillcode.py` 获取数据，调用模型，生成代码。
11. `compiledetect.py` 检测生成代码是否可编译，检测生成代码是否包含重入漏洞。
12. `perprocess.py` 数据预处理。
11. `valid.parquet`摘要代码数据。

## 实验步骤
以下是如何使用本工具的示例：

| 参数名称          | 类型    | 是否必需 | 默认值  | 说明                                                                 |
|-------------------|---------|----------|---------|----------------------------------------------------------------------|
| `--templateid`    | `str`   | 是       | 无      | 要使用的模板 ID，用于生成代码或处理文件。                            |
| `--llm`           | `str`   | 是       | 无      | 要使用的大语言模型（如 `gpt4o`, `Claude` 等）。                     |
| `--basedir`       | `str`   | 是       | `./`    | 文件路径，用于搜索 `.tofill` 文件。                                  |
| `--temperature`   | `float` | 是       | `0.0`   | LLM 的生成温度（影响输出的随机性）。                                 |
| `--csv_file`      | `str`   | 是       | 无      | 结果保存的 CSV 文件名称。                                            |

### 示例1：使用模板 ID 小于等于 7 的情况（0-3分别代表代码生成template0-3，4-7分别对应其安全template）

```bash
python main.py \
    --templateid 5 \
    --llm gpt4o \
    --basedir ./input_dir \
    --temperature 0.7 \
    --csv_file output.csv
```  

### 示例2：使用模板 ID 在 8 到 10 之间（8代表代码补全，9-10代表安全补全）

```bash
python main.py \
    --templateid 8 \
    --llm Claude \
    --basedir ./input_dir \
    --temperature 0.5 \
    --csv_file output.csv
```  

### 示例3：使用模板 ID 大于 10 的情况（代表人工标注补全）
```bash
python main.py \
    --templateid 12 \
    --llm gpt4o \
    --basedir ./input_dir \
    --temperature 0.3 \
    --csv_file results.csv
```  
