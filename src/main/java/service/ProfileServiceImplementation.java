package service;

import dto.ProfileDTO;
import dto.ResumeDTO;
import entity.Profile;
import entity.Resume;
import exception.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProfileRepository;
import repository.ResumeRepository;
import utility.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("profileService")
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ResumeRepository resumeRepository;
    @Override
    public Long createProfile(String email) throws Exception {
        Profile profile = new Profile();
        profile.setId(Utilities.getNextSequence("profiles"));
        profile.setEmail(email);
        profile.setSkills(new ArrayList<>());
        profile.setExperiences(new ArrayList<>());
        profile.setCertifications(new ArrayList<>());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public ProfileDTO getProfile(Long id) throws JobPortalException {
        return profileRepository.findById(id).orElseThrow(()->new JobPortalException("Profile not found")).toDTO();
    }

    @Override
    public ProfileDTO updateProfile(ProfileDTO profileDTO) throws JobPortalException {
        profileRepository.findById(profileDTO.getId()).orElseThrow(()->new JobPortalException("Profile not found"));
        profileRepository.save(profileDTO.toEntity());
        return profileDTO;
    }

    @Override
    public void resume(ResumeDTO resumeDTO) throws JobPortalException {
        try {
            Optional<Resume> existingResumeOpt = resumeRepository.findById(resumeDTO.getId());

            if (existingResumeOpt.isPresent()) {
                Resume existingResume = existingResumeOpt.get();
                existingResume.setResume(resumeDTO.getResume().getBytes());
                resumeRepository.save(existingResume);
            } else {
                resumeRepository.save(resumeDTO.toEntity());
            }
        } catch (Exception e) {
            throw new JobPortalException("Error saving/updating resume");
        }
    }


    @Override
    public List<ProfileDTO> getAllProfiles() throws JobPortalException {
        return profileRepository.findAll().stream().map((x)->x.toDTO()).toList();
    }
}
