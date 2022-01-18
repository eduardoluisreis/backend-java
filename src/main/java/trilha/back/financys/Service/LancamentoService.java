package trilha.back.financys.Service;

import org.apache.logging.log4j.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.Exceptions.DivisaoZeroException;
import trilha.back.financys.Repository.LancamentoRepository;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LogManager.getLogger(LancamentoService.class);

    public LancamentoService(LancamentoRepository lancamentoRepository, ModelMapper modelMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.modelMapper = modelMapper;
    }
    public LancamentoEntity salvar(LancamentoDTO lancamentoDTO) {

        return  lancamentoRepository.save(mapToEntity(lancamentoDTO));
    }

    public List<LancamentoEntity> getAll() {
        return ResponseEntity.ok().body(lancamentoRepository.findAll()).getBody();

    }


    public LancamentoEntity getId(Long id) {
        Optional<LancamentoEntity> requestedCategoria = lancamentoRepository.findById(id);
        if (requestedCategoria.isPresent()) {
            lancamentoRepository.getById(id);
        } else {
            logger.info("id nao encontrado");
        }
        return lancamentoRepository.getById(id);
    }

    public void atualizaLancamento(LancamentoEntity lancamento, Long id) {
//esse metodo pode ser melhorado a escrita dele, tente fazer sozinho
        LancamentoEntity lancamentoEdita = lancamentoRepository.findById(id)
                .orElseThrow();
        lancamentoEdita.setName(lancamento.getName());
        lancamentoEdita.setDescription(lancamento.getDescription());
        lancamentoEdita.setAmount(lancamento.getAmount());
        lancamentoEdita.setPaid(lancamento.isPaid());
        lancamentoEdita.setType(lancamento.getType());
        lancamentoEdita.setData(lancamento.getData());
        lancamentoEdita.setCategoryId(lancamentoEdita.getCategoryId());
        ResponseEntity.ok().body(lancamentoRepository.save(lancamentoEdita));
    }

    public void Deletar(Long id) {
        lancamentoRepository.deleteById(id);
    }


    private LancamentoDTO mapToDto(LancamentoEntity entity) {
        return modelMapper.map(entity, LancamentoDTO.class);
    }

    public Integer calculaMedia(Integer x , Integer y) throws DivisaoZeroException {
//        int x = 10;
//        int y =0;

        try {
            if(y<=0){
                throw new DivisaoZeroException("NÃO EXISTE DIVISÃO POR ZERO");
            }
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        return (x/y);
    }

    private LancamentoEntity mapToEntity(LancamentoDTO dto) {
        return modelMapper.map(dto, LancamentoEntity.class);
    }


}
